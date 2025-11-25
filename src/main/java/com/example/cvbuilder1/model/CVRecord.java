package com.example.cvbuilder1.model;

public class CVRecord
{
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    public CVRecord(int a, String b, String c, String d, String e, String f, String g, String h, String i)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }

    public CVRecord(String b, String c, String d, String e, String f, String g, String h, String i)
    {
        this(-1, b, c, d, e, f, g, h, i);
    }

    public int a() { return a; }
    public String b() { return b; }
    public String c() { return c; }
    public String d() { return d; }
    public String e() { return e; }
    public String f() { return f; }
    public String g() { return g; }
    public String h() { return h; }
    public String i() { return i; }

    @Override
    public String toString()
    {
        return "#" + a + ": " + b + " (" + c + ")";
    }
}