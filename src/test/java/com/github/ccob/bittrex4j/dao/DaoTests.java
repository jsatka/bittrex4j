package com.github.ccob.bittrex4j.dao;


// import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import pl.pojo.tester.api.assertion.Method;

// import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Collection;
import java.util.Set;
import java.math.BigDecimal;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.CONSTRUCTOR;
import static pl.pojo.tester.api.assertion.Method.GETTER;
// import static pl.pojo.tester.api.assertion.Method.SETTER;


@RunWith(Parameterized.class)
public class DaoTests {

    private Class<?> classUnderTest;

    @Parameters(name="{0}")
    public static Collection<Class<? extends Object>> testParameters() {
        Set<Class<?>> classes = new Reflections(DaoTests.class.getPackage().getName(),
                new SubTypesScanner(false)).getSubTypesOf(Object.class);

        //Dont want to test the tester class itself
        classes.remove(DaoTests.class);
        return classes;
    }

    public DaoTests(Class<?> classUnderTest){
        this.classUnderTest = classUnderTest;
    }

    @Test
    public void shouldConstructDaoPojos() {
        if (classUnderTest != Fill.class) {
            assertPojoMethodsFor(classUnderTest).testing(CONSTRUCTOR)
                    .areWellImplemented();
        } else {
            assertPojoMethodsForFill(new Method[]{CONSTRUCTOR});
        }
    }

    @Test
    public void shouldImplementDaoPojoGetters() {
        if (classUnderTest != Fill.class) {
            assertPojoMethodsFor(classUnderTest).testing(GETTER)
                    .areWellImplemented();
        } else {
            assertPojoMethodsForFill(new Method[]{GETTER});
        }
    }

    private void assertPojoMethodsForFill(Method method[]) {
        final Object[] constructorParameters = { 1L, null, "string1", "string2", BigDecimal.valueOf(2), null, BigDecimal.valueOf(4.0), BigDecimal.valueOf(5), Instant.now(), 2L, null };
        final Class[] constructorParameterTypes = { Long.class, String.class, String.class, String.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Instant.class, Long.class, String.class };
        assertPojoMethodsFor(classUnderTest)
                .create(classUnderTest, constructorParameters, constructorParameterTypes)
                .testing(method)
                .areWellImplemented();
    }


}