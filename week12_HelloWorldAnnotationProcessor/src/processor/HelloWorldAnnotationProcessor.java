package processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;


@SupportedAnnotationTypes("Hello")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HelloWorldAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager message = super.processingEnv.getMessager();
        message.printMessage(Diagnostic.Kind.NOTE, "Hello World!!!!");
        return true;
    }
}
