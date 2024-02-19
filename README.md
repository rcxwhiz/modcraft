# modcraft

# Executive Summary

I haven't even come close to finishing this code or RFC.

# Motivation

It is currently a major pain to create modpack specifications and to edit/update modpacks. It is easy to download a modpack spec from Curse(d)forge or Modrinth and use a launcher to create a modpack instance from that specification, but operations beyond that are very difficult. There is no mechanism to create a modpack specification from an instance. There is no mechanism to update a modpack instance using a new modpack specification, and there is no way to automatically update a modpack while respecting config options you have manually set or mods that you have changed. 

There are two extremely common use cases where functionality is missing. The first is customizing and distributing a modpack specification.

The second is updating a modpack instance. 

# Proposed Implementation

There should be a modpack build tool that can go from a modpack specification to an instance, or vice versa. This tool should also be able to apply updates to modpack instances. This can be accomplished with a modpack specification system that uses deltas to represent updates. 

# Drawbacks

# Alternatives

# Potential Impact and Dependencies

# Unresolved Questions

# Conclusion
