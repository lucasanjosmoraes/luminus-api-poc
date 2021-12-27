# luminus-api-poc

POC of an HTTP API using [Luminus](https://luminusweb.com).

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

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
