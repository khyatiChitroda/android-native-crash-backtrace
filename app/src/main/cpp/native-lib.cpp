#include <jni.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_suacelabassigment_MainActivity_crashNative(
        JNIEnv* env,
        jobject thiz) {

    int* ptr = nullptr;
    *ptr = 42;   // Intentional native crash (SIGSEGV)
}