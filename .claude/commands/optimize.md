---
description: Analyze code for performance issues and suggest optimizations
---

# Code Optimization

Run `git diff HEAD` and use the diff output directly as the primary source for analysis — focus only on added/changed lines (lines starting with `+`).
If there are no uncommitted changes, fall back to `git diff HEAD~1`.
Only read the full file when additional context is needed to understand a changed section (e.g., a called function's signature or class structure).

Review the provided code for the following issues in order of priority:

1. **Performance bottlenecks** - identify O(n²) operations, inefficient loops
2. **Memory leaks** - find unreleased resources, circular references
3. **Algorithm improvements** - suggest better algorithms or data structures
4. **Caching opportunities** - identify repeated computations
5. **Concurrency issues** - find race conditions or threading problems

Format your response with:
- Issue severity (Critical/High/Medium/Low)
- Location in code
- Explanation
- Recommended fix with code example

---
**Last Updated**: April 9, 2026
