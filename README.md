# searchy-benchmark

Demo and macro benchmark on wiki-news for [searchy](https://github.com/gmodena/searchy).

Build with
```
export GITHUB_ACTOR=<user>
export GITHUB_TOKEN=<token>
./gradlew build
```

# Data

The data used in this benchmark is the [wiki-news-300d-1M.vec](https://fasttext.cc/docs/en/english-vectors.html)

# Index & Search
This repo contain a small utility that can be used to index and search vectors
from the wiki-news dataset. The index is built using the [searchy](https://github.com/gmodena/searchy)
library.

## Usage
```
$ ./gradlew app:run --args="--help"
 -d,--deduplicate               Deduplicate vectors
 -i,--input <arg>               Path to the dataset
 -k,--num-results <arg>         Number of results to return
 -m,--max-node-size <arg>       Maximum node size
 -n,--num-trees <arg>           Number of trees
 -q,--num-query-vectors <arg>   Number of query vectors
 -r,--max-records <arg>         Maximum number of records to read
```

## Example
Index 10000 300 dimensional vectors and query the index for
top-k (per query) best matches on a sample (with replacement) of 100 vectors:
```
./gradlew app:run --args="--input $HOME/Downloads/dataset/wiki-news-300d-1M.vec \
    --max-records 10000 \
    --num-query-vectors 100 \
    --num-trees 3 \
    --max-node-size 15 \
    --num-results 10"
```



