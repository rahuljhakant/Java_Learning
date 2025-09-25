# Multi-threaded Web Scraper

A comprehensive multi-threaded web scraping application that demonstrates advanced Java programming concepts including concurrent programming, HTTP handling, and data extraction.

## Features

- Multi-threaded web scraping with configurable thread pool
- Concurrent URL processing and data extraction
- HTML content parsing and data extraction
- Link discovery and recursive scraping
- Keyword-based content filtering
- Thread-safe data collection and storage
- Performance monitoring and statistics
- Results export to file

## Learning Objectives

- Implement multi-threaded web scraping
- Use concurrent programming concepts (ExecutorService, Future, etc.)
- Handle HTTP requests and responses efficiently
- Parse HTML content and extract structured data
- Apply thread safety and synchronization
- Build high-performance web applications
- Use advanced Java concurrency features
- Implement comprehensive error handling

## How to Run

1. Compile the Java files:
   ```bash
   javac *.java
   ```

2. Run the program:
   ```bash
   java WebScraper
   ```

## Usage

1. **Configure Threading**: Set maximum number of threads and scraping depth
2. **Set Target URL**: Enter the starting URL for scraping
3. **Optional Keyword**: Specify a keyword to filter content
4. **Monitor Progress**: Watch real-time scraping progress and statistics
5. **View Results**: Review extracted data and save to file

## Features

- **Multi-threading**: Concurrent processing of multiple URLs
- **Data Extraction**: Extract titles, descriptions, headings, links, and images
- **Link Discovery**: Automatically discover and process related links
- **Keyword Filtering**: Filter content based on specified keywords
- **Thread Safety**: Thread-safe data collection and processing
- **Performance Monitoring**: Real-time thread and performance statistics
- **Error Handling**: Robust error handling for network and parsing issues
- **Results Export**: Save scraping results to text file

## Extracted Data

- **Page Title**: HTML page title
- **Meta Description**: Page meta description
- **Headings**: All H1-H6 headings
- **Links**: All internal and external links
- **Images**: All image sources
- **Keyword Matches**: Content containing specified keywords
- **Timestamps**: When each page was scraped

## Thread Management

- **Configurable Thread Pool**: Set maximum number of concurrent threads
- **Thread Monitoring**: Real-time monitoring of thread performance
- **Task Management**: Efficient task distribution and execution
- **Resource Management**: Proper thread lifecycle management
- **Performance Statistics**: Detailed thread and task statistics

## Code Structure

- `WebScraper.java` - Main scraping application with multi-threading
- `ThreadManager.java` - Advanced thread management and monitoring
- `ScrapedData.java` - Data container for extracted information

## Best Practices

- **Rate Limiting**: Respect website rate limits and robots.txt
- **Error Handling**: Handle network errors and malformed content gracefully
- **Resource Management**: Properly manage threads and connections
- **Data Validation**: Validate extracted data before processing
- **Performance Optimization**: Use efficient data structures and algorithms

## Author

**Created by: Rahul Kant Jha**
- Comprehensive Java Advanced Project
- Industry-standard implementations with detailed explanations
- Real-world applications and best practices
