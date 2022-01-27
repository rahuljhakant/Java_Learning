package OOPS;

public class j_inheritance_object_storage {

  static int c = 10;
  int d = 20;

  void sum() {
    c++;
  }

  int pp() {
    return 0;
  }
}

class c extends j_inheritance_object_storage {

  int sub() {
    return 0;
  }

  j_inheritance_object_storage j_inheritance_object_storage = new c();
  c cc = (OOPS.c) new j_inheritance_object_storage();
}
