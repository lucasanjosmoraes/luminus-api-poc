# luminus-api-poc

POC of an HTTP API using [Luminus](https://luminusweb.com).

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## About the project

- Useful dependencies
  - [cheshire](https://github.com/dakrone/cheshire): JSON encode/decode;
  - [conman](https://github.com/luminus-framework/conman): SQL databases management;
  - [cprop](https://github.com/tolitius/cprop): Read configs from `.edn` files;
  - [expound](https://github.com/bhb/expound): Humanize `clojure.spec` error messages;
  - [metosin/muuntaja](https://github.com/metosin/muuntaja): HTTP negotiation and encode/decode responses;
  - [metosin/reitit](https://github.com/metosin/reitit): HTTP router;
  - [metosin/ring-http-response](https://github.com/metosin/ring-http-response): HTTP statuses management;
  - [mount](https://github.com/tolitius/mount): dependencies and application state management;
  - [selmer](https://github.com/yogthos/Selmer): template system, like in Django.
- Profiles configuration
  - `:uberjar` with production-ready configuration;
  - `:dev` with exclusive libs, including one that [humanize test outputs](https://github.com/pjstadig/humane-test-output)
and other that [rerun tests, if it changes](https://github.com/jakemcc/test-refresh), besides a [tool lint](https://github.com/jonase/eastwood).
- Configuration files for each environment;
- Utils for the `user`, the default namespace of `repl`;
- Log configuration files for each environment;
- Default configurations functions for each environment, injected by [mount](https://github.com/tolitius/mount);
- Example of application configuration to transform it in a CLI;
- Example of an uncaught exception handler with its log;
- Example of how to configure: the application itself and its REPL, CLI, database migrations and lifecycle with [mount](https://github.com/tolitius/mount);
- Application routes configuration with `ring`, configuring: API routes, its swagger, a default page for the API serving
static files and a series of default handlers for the errors 404, 405 and 406 using an own HTML template;
- Example of [Luminus](https://luminusweb.com) usage and its features;
- Useful examples of unit tests;
- Clojure dockerfile example.

## Usage

Before start, you need to create `.env`, `dev-config.edn` and `test-config.edn` files. There are examples for each file.

The `.env` is only required by the postgres container and the `*.edn` ones by the application itself.

## From command line

You can:

- Start the API with `lein run`
- Run migrations with `lein migrate`
- Run all project's tests with `lein test`
- Generate `.jar` files with `lein uberjar`

If you need to debug your **API** using **REPL**, there are some commands available to help:

```clj
;; To start the API
(start)

;; To stop
(stop)

;; or restart
(restart)
```

### From Intellij

There are scripts in the directory `.run` that allow you to: run REPL, start the **API**, run migrations or tests and
generate `.jar` files. You just need to choose one of them from the dropdown menu and press play 🛀🏽.
