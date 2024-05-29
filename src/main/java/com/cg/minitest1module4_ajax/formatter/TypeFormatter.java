//package com.cg.minitest1module4_ajax.formatter;
//
//import com.cg.minitest1module4_ajax.model.Type;
//import com.cg.minitest1module4_ajax.service.ITypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.Locale;
//import java.util.Optional;
//
//@Component
//public class TypeFormatter implements Formatter<Type> {
//    @Autowired
//    ITypeService typeService;
//
//    @Override
//    public Type parse(String text, Locale locale) throws ParseException {
//        Optional<Type> optionalType = null;
//        try {
//            optionalType = typeService.findById(Long.parseLong(text));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return optionalType.get();
//    }
//
//    @Override
//    public String print(Type object, Locale locale) {
//        return "[" + object.getId() + ", " +object.getType() + "]";
//    }
//}
