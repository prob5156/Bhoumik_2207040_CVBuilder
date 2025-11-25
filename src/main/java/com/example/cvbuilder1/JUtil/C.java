package com.example.cvbuilder1.JUtil;

import com.example.cvbuilder1.model.CVRecord;
import javafx.application.Platform;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class C
{

    private final ExecutorService a = Executors.newSingleThreadExecutor();

    public void a(Consumer<List<CVRecord>> onSuccess, Consumer<Throwable> onError)
    {
        a.submit(() ->
        {
            try
            {
                List<CVRecord> b = B.h();
                Platform.runLater(() -> onSuccess.accept(b));
            }
            catch (Throwable c)
            {
                Platform.runLater(() -> onError.accept(c));
            }
        });
    }

    public void b(String b, String c, String d, String e, String f, String g, String h, String i, Consumer<CVRecord> onSuccess, Consumer<Throwable> onError)
    {
        a.submit(() ->
        {
            try
            {
                CVRecord j = B.i(b, c, d, e, f, g, h, i);
                Platform.runLater(() -> onSuccess.accept(j));
            }
            catch (Throwable k)
            {
                Platform.runLater(() -> onError.accept(k));
            }
        });
    }

    public void c(CVRecord a, Runnable onSuccess, Consumer<Throwable> onError)
    {
        this.a.submit(() ->
        {
            try
            {
                B.j(a);
                Platform.runLater(onSuccess);
            }
            catch (Throwable b)
            {
                Platform.runLater(() -> onError.accept(b));
            }
        });
    }

    public void d(int a, Runnable onSuccess, Consumer<Throwable> onError)
    {
        this.a.submit(() ->
        {
            try
            {
                B.k(a);
                Platform.runLater(onSuccess);
            }
            catch (Throwable b)
            {
                Platform.runLater(() -> onError.accept(b));
            }
        });
    }

    public void e()
    {
        a.shutdown();
    }
}