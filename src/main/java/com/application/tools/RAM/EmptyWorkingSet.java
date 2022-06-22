package com.application.tools.RAM;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class EmptyWorkingSet extends Memory {
    private interface PsapiX64 extends Library{
        public boolean EmptyWorkingSet(Pointer ptr);
    }

    private interface PsapiX32 extends Library{
        public boolean EmptyWorkingSet();
    }

    @Override
    public void clear() {
        try {
            final PsapiX64 library = (PsapiX64) Native.loadLibrary("src/main/resources/dll/psapiX64.dll", PsapiX64.class);
            Process process = Runtime.getRuntime().exec (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
//            var result = library.EmptyWorkingSet(process.toHandle());
//            System.out.println(result);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
