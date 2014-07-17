val list = List("This", "is", "a", "small", "collection")

val mappedCollection = list.map(x => x.size)

val filteredCollection = mappedCollection.filter(x => x > 2)

filteredCollection.foldLeft(0.0)((b, a) => b + a) / filteredCollection.length