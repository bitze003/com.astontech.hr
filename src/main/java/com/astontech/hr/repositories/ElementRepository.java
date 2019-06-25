package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementRepository extends CrudRepository<Element, Integer> {

    //will auto generate the reuqired code from the structure of the method name
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    Element findByElementNameStartingWith(String elementName);

    Element findByElementNameIgnoreCase(String elementName);

    List<Element> findByElementNameEndsWith(String elementName);



}
