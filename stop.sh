#!/bin/bash
kill -9 $(pgrep -f 'jetty:run') > /dev/null &
