#include <jni.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_suacelabassigment_MainActivity_crashNative(
        JNIEnv* env,
jobject /* this */) {

int* pointer = nullptr;

// Intentional native crash
*pointer = 42;
}