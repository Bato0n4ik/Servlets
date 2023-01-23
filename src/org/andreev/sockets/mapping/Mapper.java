package org.andreev.sockets.mapping;

public interface Mapper <F,T>{

    T mapping(F object);
}
