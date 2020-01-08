package com.hello.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class StrUtilTest {
    @Test
    public void testIsIdNumber() {
        Map<String, Boolean> mapIO = new HashMap<String, Boolean>() {{
            put(null, false);
            put("", false);
            put("41000119910101123X", true);
            put("410001199101011231", false);
            put("4100011991010112", false);
            put(CodeUtil.getCode(), false);
        }};
        for (Map.Entry<String, Boolean> io : mapIO.entrySet()) {
            boolean ret = StrUtil.isIdNumber(io.getKey());
            Assertions.assertEquals(io.getValue(), ret);
        }
    }

    @Test
    public void testParse() {
        Map<String, Integer> mapIO = new HashMap<String, Integer>() {{
            put(null, 0);
            put("", 0);
            put("asdf", 0);
            put("http://47.100.170.118:8080/browse/CGB-4?filter=10503", 1);
            put("http://47.100.170.118:8080/browse/CGB-4", 1);
            put("http://47.100.170.118:8080/browse/CGB-4?filter=10503&issue=DEMO-1", 2);
            put("http://47.100.170.118:8080/browse?issue=CGB-4&filter=10503", 1);
        }};

        for (Map.Entry<String, Integer> io : mapIO.entrySet()) {
            String[] ret = StrUtil.parse(io.getKey(), "[A-Z]\\w*\\-[1-9]\\d*");
            Assertions.assertEquals(io.getValue().intValue(), ret == null ? 0 : ret.length);
        }
    }

    @Test
    public void testMatches() {
        Map<String[], Boolean> mapIO = new HashMap<String[], Boolean>() {{
            put(new String[]{null, null}, false);
            put(new String[]{"AbcTestC.groovy", "((\\w*[Tt][Ee][Ss][Tt])|([Tt][Ee][Ss][Tt]\\w*)).groovy"}, false);
            put(new String[]{"AbcTest.groovy", "((\\w*[Tt][Ee][Ss][Tt])|([Tt][Ee][Ss][Tt]\\w*)).groovy"}, true);
            put(new String[]{"TestC.groovy", "((\\w*[Tt][Ee][Ss][Tt])|([Tt][Ee][Ss][Tt]\\w*)).groovy"}, true);
            put(new String[]{"Utils.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, true);
            put(new String[]{"StrUtil.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, true);
            put(new String[]{"utils.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, true);
            put(new String[]{"util.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, true);
            put(new String[]{"uti.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, false);
            put(new String[]{"Helper.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, true);
            put(new String[]{"IssueHelper.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, true);
            put(new String[]{"HelperVer.groovy", "\\w*(([Uu]tils*)|([Hh]elper)).groovy"}, false);
        }};
        for (Map.Entry<String[], Boolean> io : mapIO.entrySet()) {
            String[] params = io.getKey();
            boolean ret = StrUtil.matches(params[0], params[1]);
            Assertions.assertEquals(io.getValue(), ret);
        }
    }

    @Test
    public void testIsEmpty() {
        Map<String, Boolean> mapIO = new HashMap<String, Boolean>() {{
            put(null, true);
            put("", true);
            put("t", false);
        }};

        for (Map.Entry<String, Boolean> io : mapIO.entrySet()) {
            boolean ret = StrUtil.isEmpty(io.getKey());
            Assertions.assertEquals(io.getValue(), ret);
        }
    }

    @Test
    public void testSplit() {
        Map<String, String[]> mapIO = new HashMap<String, String[]>() {{
            put(null, null);
            put("", null);
            put("t", new String[] {"t"});
            put("t,a", new String[] {"t", "a"});
        }};

        for (Map.Entry<String, String[]> io : mapIO.entrySet()) {
            String[] ret = StrUtil.split(io.getKey(), ",");
            Assertions.assertArrayEquals(io.getValue(), ret);
        }
    }

    @Test
    public void testJoin() {
        Map<String, String[]> mapIO = new HashMap<String, String[]>() {{
            put(null, null);
            put("t", new String[] {"t"});
            put("t, a", new String[] {"t", "a"});
        }};

        for (Map.Entry<String, String[]> io : mapIO.entrySet()) {
            String ret = StrUtil.join(io.getValue(), ", ");
            Assertions.assertEquals(io.getKey(), ret);
        }
    }

    @Test
    public void testMask() {
        Map<String, String> mapIO = new HashMap<String, String>() {{
            put(null, "");
            put("", "");
            put("a", "a");
            put("str", "s*r");
            put("guest", "gu*st");
            put("-A long str to mask_", "Alon****mask");
        }};

        for (Map.Entry<String, String> io : mapIO.entrySet()) {
            Assertions.assertEquals(io.getValue(), StrUtil.mask(io.getKey()));
        }
    }

    @Test
    public void testTrimChinese() {
        Map<String, String> mapIO = new HashMap<String, String>() {{
            put(null, "");
            put("", "");
            put("str", "str");
            put("去除汉字", "");
            put("去st除汉字r", "str");
        }};

        for (Map.Entry<String, String> io : mapIO.entrySet()) {
            Assertions.assertEquals(io.getValue(), StrUtil.trimChinese(io.getKey()));
        }
    }
}
