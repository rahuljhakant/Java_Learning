package com.tutorial.projects.advanced.webscraper;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Web Scraper - Multi-threaded Web Scraping Application
 * 
 * This class demonstrates a multi-threaded web scraping application
 * that can scrape multiple websites concurrently for data extraction.
 * 
 * LEARNING OBJECTIVES:
 * - Implement multi-threaded web scraping
 * - Use concurrent programming concepts
 * - Handle HTTP requests and responses
 * - Parse HTML content and extract data
 * - Apply thread safety and synchronization
 * - Build a real-world web scraping application
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class WebScraper {
    private ExecutorService executorService;
    private Set<String> visitedUrls;
    private Queue<String> urlQueue;
    private List<ScrapedData> scrapedData;
    private int maxThreads;
    private int maxDepth;
    
    public WebScraper(int maxThreads, int maxDepth) {
        this.maxThreads = maxThreads;
        this.maxDepth = maxDepth;
        this.executorService = Executors.newFixedThreadPool(maxThreads);
        this.visitedUrls = ConcurrentHashMap.newKeySet();
        this.urlQueue = new ConcurrentLinkedQueue<>();
        this.scrapedData = Collections.synchronizedList(new ArrayList<>());
    }
    
    public static void main(String[] args) {
        System.out.println("=== Multi-threaded Web Scraper ===");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter maximum number of threads (default 5): ");
        int maxThreads = scanner.nextInt();
        if (maxThreads <= 0) maxThreads = 5;
        
        System.out.print("Enter maximum depth (default 2): ");
        int maxDepth = scanner.nextInt();
        if (maxDepth <= 0) maxDepth = 2;
        
        WebScraper scraper = new WebScraper(maxThreads, maxDepth);
        
        System.out.print("Enter starting URL: ");
        String startUrl = scanner.next();
        
        System.out.print("Enter search keyword (optional): ");
        scanner.nextLine(); // Consume newline
        String keyword = scanner.nextLine();
        
        scraper.scrape(startUrl, keyword);
        scraper.shutdown();
        
        scanner.close();
    }
    
    /**
     * Start scraping process
     */
    public void scrape(String startUrl, String keyword) {
        System.out.println("Starting web scraping...");
        System.out.println("Max threads: " + maxThreads);
        System.out.println("Max depth: " + maxDepth);
        System.out.println("Start URL: " + startUrl);
        System.out.println("Keyword: " + (keyword.isEmpty() ? "None" : keyword));
        
        urlQueue.offer(startUrl);
        
        List<Future<?>> futures = new ArrayList<>();
        
        for (int i = 0; i < maxThreads; i++) {
            Future<?> future = executorService.submit(new ScrapingWorker(keyword));
            futures.add(future);
        }
        
        // Wait for all threads to complete
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error in scraping thread: " + e.getMessage());
            }
        }
        
        displayResults();
    }
    
    /**
     * Scraping worker thread
     */
    private class ScrapingWorker implements Runnable {
        private String keyword;
        
        public ScrapingWorker(String keyword) {
            this.keyword = keyword;
        }
        
        @Override
        public void run() {
            while (!urlQueue.isEmpty()) {
                String url = urlQueue.poll();
                if (url == null) continue;
                
                if (visitedUrls.contains(url)) continue;
                visitedUrls.add(url);
                
                try {
                    scrapeUrl(url, keyword);
                } catch (Exception e) {
                    System.err.println("Error scraping URL " + url + ": " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Scrape a single URL
     */
    private void scrapeUrl(String url, String keyword) throws IOException {
        System.out.println("Scraping: " + url);
        
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(10000);
        
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.err.println("HTTP error: " + responseCode + " for URL: " + url);
            return;
        }
        
        String content = readContent(connection);
        if (content == null) return;
        
        // Extract data from content
        ScrapedData data = extractData(url, content, keyword);
        if (data != null) {
            scrapedData.add(data);
        }
        
        // Extract links for further scraping
        if (visitedUrls.size() < 100) { // Limit total URLs
            extractLinks(url, content);
        }
    }
    
    /**
     * Read content from HTTP connection
     */
    private String readContent(HttpURLConnection connection) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            
            return content.toString();
        } catch (IOException e) {
            System.err.println("Error reading content: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Extract data from HTML content
     */
    private ScrapedData extractData(String url, String content, String keyword) {
        ScrapedData data = new ScrapedData();
        data.setUrl(url);
        data.setTimestamp(new Date());
        
        // Extract title
        Pattern titlePattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
        Matcher titleMatcher = titlePattern.matcher(content);
        if (titleMatcher.find()) {
            data.setTitle(titleMatcher.group(1).trim());
        }
        
        // Extract meta description
        Pattern descPattern = Pattern.compile("<meta\\s+name=\"description\"\\s+content=\"(.*?)\"", Pattern.CASE_INSENSITIVE);
        Matcher descMatcher = descPattern.matcher(content);
        if (descMatcher.find()) {
            data.setDescription(descMatcher.group(1).trim());
        }
        
        // Extract headings
        Pattern headingPattern = Pattern.compile("<h[1-6][^>]*>(.*?)</h[1-6]>", Pattern.CASE_INSENSITIVE);
        Matcher headingMatcher = headingPattern.matcher(content);
        List<String> headings = new ArrayList<>();
        while (headingMatcher.find()) {
            String heading = headingMatcher.group(1).replaceAll("<[^>]+>", "").trim();
            if (!heading.isEmpty()) {
                headings.add(heading);
            }
        }
        data.setHeadings(headings);
        
        // Extract links
        Pattern linkPattern = Pattern.compile("<a[^>]+href=\"([^\"]+)\"[^>]*>(.*?)</a>", Pattern.CASE_INSENSITIVE);
        Matcher linkMatcher = linkPattern.matcher(content);
        List<String> links = new ArrayList<>();
        while (linkMatcher.find()) {
            String link = linkMatcher.group(1).trim();
            if (!link.isEmpty() && !link.startsWith("#")) {
                links.add(link);
            }
        }
        data.setLinks(links);
        
        // Extract images
        Pattern imgPattern = Pattern.compile("<img[^>]+src=\"([^\"]+)\"[^>]*>", Pattern.CASE_INSENSITIVE);
        Matcher imgMatcher = imgPattern.matcher(content);
        List<String> images = new ArrayList<>();
        while (imgMatcher.find()) {
            String img = imgMatcher.group(1).trim();
            if (!img.isEmpty()) {
                images.add(img);
            }
        }
        data.setImages(images);
        
        // Check for keyword
        if (!keyword.isEmpty()) {
            boolean containsKeyword = content.toLowerCase().contains(keyword.toLowerCase());
            data.setContainsKeyword(containsKeyword);
        }
        
        return data;
    }
    
    /**
     * Extract links for further scraping
     */
    private void extractLinks(String baseUrl, String content) {
        try {
            URL base = new URL(baseUrl);
            Pattern linkPattern = Pattern.compile("<a[^>]+href=\"([^\"]+)\"[^>]*>", Pattern.CASE_INSENSITIVE);
            Matcher linkMatcher = linkPattern.matcher(content);
            
            while (linkMatcher.find()) {
                String link = linkMatcher.group(1).trim();
                if (link.isEmpty() || link.startsWith("#")) continue;
                
                // Convert relative URLs to absolute
                URL absoluteUrl = new URL(base, link);
                String absoluteLink = absoluteUrl.toString();
                
                // Only add if not visited and within same domain
                if (!visitedUrls.contains(absoluteLink) && 
                    absoluteUrl.getHost().equals(base.getHost())) {
                    urlQueue.offer(absoluteLink);
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("Error processing links: " + e.getMessage());
        }
    }
    
    /**
     * Display scraping results
     */
    private void displayResults() {
        System.out.println("\n=== Scraping Results ===");
        System.out.println("Total URLs visited: " + visitedUrls.size());
        System.out.println("Total data extracted: " + scrapedData.size());
        
        if (scrapedData.isEmpty()) {
            System.out.println("No data extracted.");
            return;
        }
        
        System.out.println("\nExtracted Data:");
        for (ScrapedData data : scrapedData) {
            System.out.println("\nURL: " + data.getUrl());
            System.out.println("Title: " + data.getTitle());
            System.out.println("Description: " + data.getDescription());
            System.out.println("Headings: " + data.getHeadings().size());
            System.out.println("Links: " + data.getLinks().size());
            System.out.println("Images: " + data.getImages().size());
            if (data.isContainsKeyword()) {
                System.out.println("Contains keyword: Yes");
            }
            System.out.println("Timestamp: " + data.getTimestamp());
        }
        
        // Save results to file
        saveResultsToFile();
    }
    
    /**
     * Save results to file
     */
    private void saveResultsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("scraping_results.txt"))) {
            writer.println("Web Scraping Results");
            writer.println("===================");
            writer.println("Total URLs: " + visitedUrls.size());
            writer.println("Total Data: " + scrapedData.size());
            writer.println();
            
            for (ScrapedData data : scrapedData) {
                writer.println("URL: " + data.getUrl());
                writer.println("Title: " + data.getTitle());
                writer.println("Description: " + data.getDescription());
                writer.println("Headings: " + data.getHeadings());
                writer.println("Links: " + data.getLinks().size());
                writer.println("Images: " + data.getImages().size());
                writer.println("Timestamp: " + data.getTimestamp());
                writer.println("---");
            }
            
            System.out.println("\nResults saved to scraping_results.txt");
        } catch (IOException e) {
            System.err.println("Error saving results: " + e.getMessage());
        }
    }
    
    /**
     * Shutdown the scraper
     */
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
    
    /**
     * Scraped data container
     */
    public static class ScrapedData {
        private String url;
        private String title;
        private String description;
        private List<String> headings;
        private List<String> links;
        private List<String> images;
        private boolean containsKeyword;
        private Date timestamp;
        
        public ScrapedData() {
            this.headings = new ArrayList<>();
            this.links = new ArrayList<>();
            this.images = new ArrayList<>();
        }
        
        // Getters and setters
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        
        public List<String> getHeadings() { return headings; }
        public void setHeadings(List<String> headings) { this.headings = headings; }
        
        public List<String> getLinks() { return links; }
        public void setLinks(List<String> links) { this.links = links; }
        
        public List<String> getImages() { return images; }
        public void setImages(List<String> images) { this.images = images; }
        
        public boolean isContainsKeyword() { return containsKeyword; }
        public void setContainsKeyword(boolean containsKeyword) { this.containsKeyword = containsKeyword; }
        
        public Date getTimestamp() { return timestamp; }
        public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    }
}
