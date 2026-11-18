# Java Specializations: JavaFX and Android

Platform-specific projects have separate toolchains and should remain outside
the root Maven build. These guides give each topic a concrete first milestone
without making the core Java lessons depend on a desktop toolkit or Android
SDK.

## JavaFX desktop application

JavaFX is not part of the JDK. Create a separate Maven project using the
OpenJFX Maven plugin and the current OpenJFX release for your platform. Keep
JavaFX dependencies and native platform artifacts in that project rather than
adding them to this repository's shared build.

Create `src/main/java/example/HelloFx.java`:

```java
package example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloFx extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX learning app");
        stage.setScene(new Scene(new Label("Hello, JavaFX"), 360, 120));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Use the OpenJFX documentation to configure `javafx-maven-plugin` and
`javafx-controls`, then run `mvn javafx:run`. Next, add an FXML view, a
controller, property bindings, observable collections, and an integration
test. Keep UI updates on the JavaFX Application Thread; move blocking I/O off
that thread and return results through a JavaFX `Task` or `Service`.

## Android application

Android uses Java or Kotlin on the Android SDK, not a regular Java SE runtime.
Install Android Studio and its SDK, create a separate Empty Views Activity
project, and select Java as the source language. Build with the Gradle wrapper:

```bash
./gradlew test
./gradlew assembleDebug
```

For a first interaction, use the generated Activity's `onCreate` method to
build a small native view and keep the result in the view tree:

```java
@Override
protected void onCreate(Bundle state) {
    super.onCreate(state);
    EditText name = new EditText(this);
    name.setHint("Your name");
    TextView greeting = new TextView(this);
    Button submit = new Button(this);
    submit.setText("Greet");
    submit.setOnClickListener(view ->
            greeting.setText("Hello, " + name.getText().toString().trim()));

    LinearLayout content = new LinearLayout(this);
    content.setOrientation(LinearLayout.VERTICAL);
    content.addView(name);
    content.addView(submit);
    content.addView(greeting);
    setContentView(content);
}
```

Add Android SDK imports for `Bundle`, `Button`, `EditText`, `LinearLayout`,
and `TextView` when using this in an Activity.

Start with an Activity that renders a small form, then add lifecycle-aware
state, repository-based data access, permission handling, and UI tests on an
emulator. Make network requests off the main thread, request only necessary
permissions, store secrets with Android Keystore-backed APIs, and follow the
platform's current target-SDK and accessibility guidance. Do not copy server
credentials into the app; mobile binaries can be inspected.

These workflows require their platform SDKs and are intentionally not part of
`mvn test` or the root CI matrix.
