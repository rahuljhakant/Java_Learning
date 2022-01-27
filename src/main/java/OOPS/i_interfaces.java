package OOPS;

/*
 * Interface is a concept which is used to achieve abstraction in Java.
 * This is the only way by which we can achieve full abstraction. Interfaces
 * are syntactically similar to classes, but you cannot create instance of an
 * Interface and their methods are declared without having any body.
 * */

interface i_interfaces {
  int happy();

  void move();

  int a = 30;
}

interface j_interface {
  int a = 10;
}

interface k_interface {
  int a = 20;
}

interface l_interface extends j_interface, k_interface, i_interfaces {
  @Override
  int happy();

  @Override
  void move();

  int c = i_interfaces.a;
}

abstract class WillTakeInterface implements i_interfaces, l_interface {

  @Override
  public int happy() {
    return 0;
  }

  @Override
  public void move() {}

  int p = c;
}

class i_interface extends WillTakeInterface {

  @Override
  public int happy() {
    return super.happy();
  }
}
