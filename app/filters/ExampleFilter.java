package filters;

import play.mvc.EssentialAction;
import play.mvc.EssentialFilter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.Executor;


@Singleton
public class ExampleFilter extends EssentialFilter {

    private final Executor exec;


    @Inject
    public ExampleFilter(Executor exec) {
        this.exec = exec;
    }

    @Override
    public EssentialAction apply(EssentialAction next) {
        return EssentialAction.of(request ->
            next.apply(request).map(result ->
                 result.withHeader("X-ExampleFilter", "foo"), exec)
        );
    }
}
