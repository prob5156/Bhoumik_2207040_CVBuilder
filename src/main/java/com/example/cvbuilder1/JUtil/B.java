package com.example.cvbuilder1.JUtil;

import com.example.cvbuilder1.model.CVRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class B
{

    private static final String c = "jdbc:sqlite:cv_records.db";
    private static Connection d;

    private static final String e =
            "CREATE TABLE IF NOT EXISTS cv_nodes (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "json_data TEXT NOT NULL" +
                    ");";

    public static void f() throws SQLException
    {
        try
        {
            if (d == null || d.isClosed())
            {
                d = DriverManager.getConnection(c);
                g();
            }
        }
        catch (SQLException a)
        {
            throw new RuntimeException(a);
        }
    }

    public static void g() throws SQLException
    {
        try
        {
            PreparedStatement a = d.prepareStatement(e);
            a.executeUpdate();
        }
        catch (SQLException a)
        {
            throw new RuntimeException(a);
        }
    }

    public static List<CVRecord> h() throws SQLException
    {
        List<CVRecord> a = new ArrayList<>();
        String b = "SELECT * FROM cv_nodes ORDER BY id ASC";

        try (PreparedStatement c = d.prepareStatement(b);
             ResultSet k = c.executeQuery())
        {
            while (k.next())
            {
                int l = k.getInt("id");
                String m = k.getString("json_data");
                String n = A.a("b", m);
                String o = A.a("c", m);
                String p = A.a("d", m);
                String q = A.a("e", m);
                String r = A.a("f", m);
                String s = A.a("g", m);
                String t = A.a("h", m);
                String u = A.a("i", m);
                a.add(new CVRecord(l, n, o, p, q, r, s, t, u));
            }
        }
        return a;
    }


    public static CVRecord i(String b, String c, String d, String e, String f, String g, String h, String i) throws SQLException
    {
        String j = A.a(b, c, d, e, f, g, h, i);
        String k = "INSERT INTO cv_nodes (json_data) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(B.c);
             PreparedStatement ps = conn.prepareStatement(k, Statement.RETURN_GENERATED_KEYS))
        {

            ps.setString(1, j);
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys())
            {
                if (keys.next())
                {
                    int a = keys.getInt(1);
                    return new CVRecord(a, b, c, d, e, f, g, h, i);
                }
                else
                {
                    throw new SQLException("Failed to retrieve generated id.");
                }
            }
        }
    }

    public static void j(CVRecord a) throws SQLException
    {
        String b = A.a(a.b(), a.c(), a.d(), a.e(), a.f(), a.g(), a.h(), a.i());
        String c = "UPDATE cv_nodes SET json_data = ? WHERE id = ?";

        try (PreparedStatement d = B.d.prepareStatement(c))
        {
            d.setString(1, b);
            d.setInt(2, a.a());
            d.executeUpdate();
        }
    }

    public static void k(int a) throws SQLException
    {
        String b = "DELETE FROM cv_nodes WHERE id = ?";

        try (PreparedStatement c = d.prepareStatement(b))
        {
            c.setInt(1, a);
            c.executeUpdate();
        }
    }
}