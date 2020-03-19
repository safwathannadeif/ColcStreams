package com.shd.data;
import com.shd.colcstreams.intersecmatch.longlists.LongListsMatchingAndDistinct;

import java.util.UUID;
import java.util.function.Function;
public class StudentOverideMatcingKey extends LongListsMatchingAndDistinct<Student> {

    public Function<Student, String> xElmMakeKeyFunci =  (std) -> {
        String retStr = UUID.nameUUIDFromBytes((std.getName() + std.getAge()).getBytes()).toString().replaceAll("-", "");
        return retStr ;
    };
    @Override
    public  void setxElmMakeKeyFunci(Function<Student, String> xElmMakeKeyFunci) {
        this.xElmMakeKeyFunci = xElmMakeKeyFunci;
    }

    @Override
    public Function<Student, String> getxElmMakeKeyFunci( ) {
        return xElmMakeKeyFunci ;
    }
}
