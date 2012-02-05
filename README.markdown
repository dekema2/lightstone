Lightstone
==========

![Lightstone Logo](https://github.com/UnXoft-Interactive/lightstone/raw/master/etc/logo/logo-small.png)

Introduction
------------

Lightstone is an open-source implementation of the
[Minecraft](http://minecraft.net) server software written in Java. 
It was originally created by [Graham Edgecombe](https://github.com/grahamedgecombe), but [UnXoft Interactive](http://unxoft.com)
has picked up development on it as of Minecraft 1.0.

The official server software has some shortcomings such as the use of threaded,
synchronous I/O along with high CPU and RAM usage. Lightstone aims to be a
lightweight and high-performance alternative.

Building
--------

Lightstone can be built with the
[Java Development Kit](http://oracle.com/technetwork/java/javase/downloads) and
Maven using the pom.xml

If you have not yet done so, you will need to download the project's
dependencies by running as maven- update dependencies command. This only needs
to be done once initially and when the dependencies are updated.

Using eclipse run as maven build and it will build the project.

Running
-------

Although not recommended, the server can be started via Maven. This is useful
for certain IDEs e.g. NetBeans which require an Maven target to run the project.


Testing
-------

The unit tests can be executed using the run as macen test button in eclipse.

Credits
-------

### Contributors

 * [Graham Edgecombe](https://github.com/grahamedgecombe) - the original creator of lightstone
 * Daniel Vidmar(creatorfromhell) for any future updates


### Miscellaneous Credits

 * [The Minecraft Coalition](http://wiki.vg/wiki) - protocol and formats
   research.
 * [Jonathan Edgecombe](http://jonathanedgecombe.com) - designed the logo.
 * [Scaevolus](http://minecraftforum.net/memberlist.php?mode=viewprofile&u=60394) - author
   of the original McRegion code, upon which the Lightstone implementation is
   based.
 * [Trustin Lee](http://gleamynode.net) - author of the
   [Netty](http://jboss.org/netty) and
   [APIviz](http://code.google.com/p/apiviz) libraries.
 * All the people behind [JRuby](http://jruby.org), [JUnit](http://junit.org),
   [Ant](http://ant.apache.org), [Ivy](http://ant.apache.org/ivy),
   [Graphviz](http://graphviz.org) and [Java](http://java.oracle.com).
 * [Notch](http://mojang.com/notch) and all the other people at
   [Mojang](http://mojang.com) - for making such an awesome game in the first
   place!

Source Code
-----------

The original Lightstone source code can be found on
[GitHub](https://github.comUnXoft-Interactive/lightstone). Feedback and patches
are welcome!

IRC
---

There is an IRC channel on `irc.esper.net` - `#lightstone` - for discussing
development. Feel free to drop by some time.

Copyright
---------

Lightstone is open-source software released under the MIT license, please see
the `LICENSE` file for details.

