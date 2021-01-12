package io.lcalmsky.leetcode;

import com.google.common.base.CaseFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ReadmeMaker {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("# leetcode\n" +
                "> Repository for leetcode\n" +
                "\n" +
                "![Bintray](https://img.shields.io/badge/language-java%2F8-orange)\n" +
                "![Bintray](https://img.shields.io/badge/build-gradle-yellowgreen)\n" +
                "![Bintray](https://img.shields.io/badge/test-junit5-blue)\n" +
                "\n" +
                "### Overview\n" +
                "Solve the algorithm problems <a href=\"leetcode.com\">leetcode.com</a> provides.\n" +
                "\n" +
                "The conventions used in the project are:\n" +
                "- branch: last path of leetcode problem url\n" +
                "- package: converting last path of leetcode problem url to snake case\n" +
                "- class: Solution.java\n" +
                "- test: SolutionTest.java\n" +
                "\n" +
                "ex)\n" +
                "<pre><code>" +
                "url     https://leetcode.com/problems/<b>wildcard-matching</b>\n" +
                "branch  feature/<b>wildcard-matching</b>\n" +
                "package io.lcalmsky.leetcode.<b>wildcard_matching</b>\n" +
                "class   io.lcalmsky.leetcode.<b>wildcard_matching.Solution</b>\n" +
                "test    io.lcalmsky.leetcode.<b>wildcard_matching.SolutionTest</b>\n" +
                "</code></pre>\n" +
                "\n" +
                "### List of problems");
        File file = new File("/Users/a1101243/git-repo/leetcode/src/main/java/io/lcalmsky/leetcode");
        String[] list = file.list();
        Arrays.sort(list);
        for (String f : list) {
            String title = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, f);
            sb.append(String.format("- [%s](https://github.com/lcalmsky/leetcode/tree/master/src/main/java/io/lcalmsky/leetcode/%s)\n", title, f));
        }
        System.out.println(sb.toString());
        Files.write(Paths.get("README.md"), sb.toString().getBytes(), StandardOpenOption.WRITE);
    }
}
