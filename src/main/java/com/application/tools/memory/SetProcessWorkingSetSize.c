#include <windows.h>
#include <tlhelp32.h>
#include <jni.h>
#include "com_application_tools_memory_Cleaning.h"

JNIEXPORT void JNICALL Java_Cleaning_use(JNIEnv *env, jobject obj)
{
	PROCESSENTRY32W pe32;
    HANDLE snapshot = CreateToolhelp32Snapshot(TH32CS_SNAPALL, 0);
    pe32.dwSize = sizeof(PROCESSENTRY32W);

    do{
        HANDLE processHandle = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pe32.th32ProcessID);
        SetProcessWorkingSetSize(processHandle, -1, -1);
    } while (Process32NextW(snapshot, &pe32));
}

