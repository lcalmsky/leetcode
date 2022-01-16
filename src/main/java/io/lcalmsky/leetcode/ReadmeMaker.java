package io.lcalmsky.leetcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ReadmeMaker {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("# leetcode\n" +
                "> Repository for source codes of leetcode\n" +
                "\n" +
                "![Bintray](https://img.shields.io/badge/language-java%2F8-orange)\n" +
                "![Bintray](https://img.shields.io/badge/build-gradle-yellowgreen)\n" +
                "![Bintray](https://img.shields.io/badge/test-junit5-blue)\n" +
                "\n" +
                "### Overview\n" +
                "Solve the algorithm problems <a href=\"leetcode.com\">leetcode.com</a> provides.\n" +
                "\n" +
                "The conventions used in the project are:\n" +
                "- package: converting last path of leetcode problem url to snake case\n" +
                "- class: Solution.java\n" +
                "- test: SolutionTest.java\n" +
                "\n" +
                "ex)\n" +
                "<pre><code>" +
                "url     https://leetcode.com/problems/<b>wildcard-matching</b>\n" +
                "package io.lcalmsky.leetcode.<b>wildcard_matching</b>\n" +
                "class   io.lcalmsky.leetcode.<b>wildcard_matching.Solution</b>\n" +
                "test    io.lcalmsky.leetcode.<b>wildcard_matching.SolutionTest</b>\n" +
                "</code></pre>\n" +
                "\n" +
                "### List of problems\n");
        File file = new File("src/main/java/io/lcalmsky/leetcode");
        String[] list = file.list();
        assert list != null;
        Arrays.sort(list);
        for (String f : list) {
            if (f.endsWith(".md")) continue;
            if (!f.endsWith(".java")) {
                String title = f.replace('_', ' ').trim();
                sb.append(String.format("- [%s](https://github.com/lcalmsky/leetcode/tree/master/src/main/java/io/lcalmsky/leetcode/%s)\n", title, f));
            }
        }
        System.out.println(sb.toString());
        Files.write(Paths.get("README.md"), sb.toString().getBytes(), StandardOpenOption.WRITE);
    }
}
