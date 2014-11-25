Ejemplo-Volley
==============

-  VolleyExample:  is the project example which contains a sample made with the Volley library which connects to a remote server.

-  php_files: contains the .php file which is located on the server. For this example only verified that received a POST ['tag'] and returns a string in JSON format

-  Volley: is the library used for this example


What is Volley library exactly for?
===================================
Volley is an HTTP library that makes networking for Android apps easier and most importantly, faster. Volley is available through the open AOSP repository.

Volley offers the following benefits:
======================================
- Automatic scheduling of network requests.
- Multiple concurrent network connections.
- Transparent disk and memory response caching with standard HTTP cache coherence.
- Support for request prioritization.
- Cancellation request API. You can cancel a single request, or you can set blocks or scopes of requests to cancel.
- Ease of customization, for example, for retry and backoff.
- Strong ordering that makes it easy to correctly populate your UI with data fetched asynchronously from the network.
- Debugging and tracing tools.


The core Volley library is developed in the open AOSP repository at frameworks/volley and contains the main request dispatch pipeline as well as a set of commonly applicable utilities, available in the Volley "toolbox." The easiest way to add Volley to your project is to clone the Volley repository and set it as a library project:

Git clone the repository by typing the following at the command line:
git clone https://android.googlesource.com/platform/frameworks/volley

