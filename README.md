# Sauce Labs Android Native Crash Assignment

This project demonstrates a minimal Android application that intentionally crashes in native code and reports the crash to Backtrace.

## Overview

The application contains a simple button. When the button is pressed, a JNI method is called which triggers a segmentation fault in native C++ code. This crash is captured and sent to Backtrace.

The goal of the project is to demonstrate:

* JNI integration
* Native crash generation
* Crash reporting with Backtrace

## How it works

1. The UI is implemented using Jetpack Compose.
2. When the "Crash App" button is clicked, the app calls a native function using JNI.
3. The native code intentionally dereferences a null pointer.
4. This produces a SIGSEGV crash.
5. The crash is reported to the Backtrace dashboard.

## Running the project

1. Open the project in Android Studio.
2. Run the app on an emulator or Android device.
3. Press the **Crash App** button.

The app will crash intentionally and the crash will appear in the Backtrace dashboard.

## Native crash example

```cpp
int* ptr = nullptr;
*ptr = 42;
```

This triggers a segmentation fault (SIGSEGV).

## Tech used

* Kotlin
* Jetpack Compose
* Android NDK / JNI
* Backtrace Android SDK

---

## Author

Khyati Chitroda
