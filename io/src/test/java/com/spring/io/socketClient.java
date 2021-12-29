package com.spring.io;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;

public class socketClient {

    @Test
    public void test() throws IOException {


        try (Socket socket = new Socket("127.0.0.1", 7700);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true, Charset.forName("gbk"));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String text = """
                    C330300000000000002537<?xml version="1.0" encoding="GBK"?>
                        <message>\s
                        <head>
                        <field name="SendDate">20201007</field>
                        <field name="SendTime">085533</field>
                        <field name="SendSeqNo">1张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红
                        张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红张金红33030201009050001125</field>
                        <field name="TxUnitNo">330300000000000</field>
                        <field name="SendNode">C33030</field>
                        <field name="TxCode">BDC300</field>
                        <field name="ReceiveNode">301000</field>
                        <field name="CustNo"></field>
                        <field name="OperNo">001</field>
                        </head>
                        <body>
                        <field name="AcctNo">6222623110008467274</field>
                        <field name="AcctName">张金红</field>
                        <field name="DocType">01</field>
                        <field name="IdNum">350781198103254824</field>
                        <field name="Bk1"></field>
                         <field name="Bk2"></field>
                         <field name="Bk3"></field>
                         <field name="Bk4"></field>
                         <field name="Bk5"></field>
                         <field name="Bk6"></field>
                         </body>\s
                        </message>""";

            out.println(text);

            System.out.println(in.readLine());
        }
    }
}
