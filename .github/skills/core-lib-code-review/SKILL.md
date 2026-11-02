---
name: core-lib-code-review
description: Review criteria for core-lib pull requests.
---

# core-lib review criteria

- `com.example.core.session` is public API used by other apps. Removing or changing a
  public declaration while a consumer still uses it is a BLOCKER.
- Deprecate before removing: a public declaration needs one release with `@Deprecated`.
- Views must not keep a reference to an Activity beyond their own lifetime.
- No blocking calls on the main thread.
