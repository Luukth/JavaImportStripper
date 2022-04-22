package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AppTest
{
    @ParameterizedTest
    @MethodSource("importProvider")
    void shouldReturnPackage(String _import, String _package)
    {
        assertEquals(_package, App.getPackage(_import));
    }

    static Stream<Arguments> importProvider() {
        return Stream.of(
                arguments("nl.han.ica.Parser", "nl.han.ica"),
                arguments("nl.han.ica.*", "nl.han.ica"),
                arguments("nl.han.ica.Parser.Exception", "nl.han.ica"),
                arguments("han", "han"),
                arguments("nl.han.Pipeline", "nl.han"),
                arguments("nl.han.ica.icss.ast.types.ExpressionType.*", "nl.han.ica.icss.ast.types"),
                arguments("nl.han.ica.icss.ast.types.ExpressionType.SCALAR", "nl.han.ica.icss.ast.types")
        );
    }
}
