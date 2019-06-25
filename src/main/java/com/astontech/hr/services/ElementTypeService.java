package com.astontech.hr.services;


import com.astontech.hr.domain.ElementType;

import java.util.List;

public interface ElementTypeService {

    Iterable<ElementType> listAllElementType();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType (Integer id);

    //custom

    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

//    ElementType findByElementTypeIgnoreCase(String elementType);

}


