# ComposeFetchReward

makes a retrofit network request to  https://fetch-hiring.s3.amazonaws.com/hiring.json on kotlin
coroutines Dispatchers.IO displaying the data in a ComposeUI List Component to the MainActivity via 
Component Binding updating the MutableStateof<Item> list or displaying the error in a toast on the
Dispatchers.Main.

Compose UI lazy Column with Itemindexed

Producing the ItemViewModel retrieving the data from the itemsRepository.
performing a group sort and filter operations on the list before serving the data on the 
main thread.

side notes:
kotlin functions I wanted to use to manipulate the list but wasn't able.

response.body?.groupBy's not working for some weird reason but sortby() does the same operations 
response.body?.filter's  not working for some weird reason but removeAll() does the same operations
