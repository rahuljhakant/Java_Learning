package OOPS;

public abstract class h_abstract_class {

  abstract String abc();

  public String hello() {
    return "";
  }

  private String hello = "hello";
  
  public String getHello() {
    return hello;
  }
}

abstract class child extends h_abstract_class {

  @Override
  String abc() {
    return "null";
  }

  String p = this.getHello();

  @Override
  public String hello() {
    return p;
  }
}

class abc extends child {

  public static void main(String[] args) {
    abc abc = new abc();
    System.out.println(abc.hello());
  }
}
