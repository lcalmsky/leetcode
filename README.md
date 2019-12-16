### Summary
Solve the algorithm problems <a href="leetcode.com">leetcode.com</a> provided.

The path part of each problem's uri is the same as the branch name, which is converted to the snake case to be used as the package name, and which is converted to the upper camel case + "Tests" to be used for a class name.

ex)
```
url     https://leetcode.com/problems/wildcard-matching
branch  feature/wildcard-matching
package io.lcalmsky.leetcode.wildcard_matching
class   io.lcalmsky.leetcode.wildcard_matching.WildcardMatching
test    io.lcalmsky.leetcode.wildcard_matching.WildcardMatchingTests
```

There is an analysis (README.md) in the package for each problem to solve the algorithm.