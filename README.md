latex input:        mmd-article-header
Title:              Allocator
Author:             Ethan C. Petuchowski
Base Header Level:  1
latex mode:         memoir
Keywords:           Programming, Fundamentals, Data Structures, Algorithms, Scheduling, Design, Concept
CSS:                http://fletcherpenney.net/css/document.css
xhtml header:       <script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
latex input:        mmd-natbib-plain
latex input:        mmd-article-begin-doc
latex footer:       mmd-memoir-footer

# At this point all that remains is code

## Design

* It could be something where **each vote has a value according to how highly you rated it**.
    * Like you can give 10 jobs a 1-10 score, and **it tries to minimize the global score** (esp. while preferring not to totally screw anyone individually).
    * So every job on the jobs-list can have a score 1-10 or N/A.
        * And you must pick *up to* 10 slots.
    * An N/A slot may still be chosen for you (hopefully *not*), because it gives a default score of 11.

* Being an officer makes each of your points worth one less (bc that means giving *you* a worse thing is *not as bad* as doing the same for a non-officer) to make it so you *kind of* get gypped.

* **Side note:** wouldn't it be nice to have a nice suite of **unit tests** and a nice **class hierarchy**?
        
## Implementation

### Classes


#### Person
* A `Person` has an `ArrayOf[Preferences]`

#### Preference
* A `Preference` is an `Int` that defines a `Person's` *cost* of being assigned a `Job`

#### Job
* A `Job` has a `Person` who is assigned to it
* A `Job` is defined by an `Int`, which is *its* index into the `Person` \\(\rightarrow\\) `ArrayOf[Preferences]`



### Algorithm

* Well, the naïve way to start is obviously just **brute force** trying everything, and keeping a list of tuples of `(finalState, finalScore)`
    * This can be trivially implement
    * **This is clearly what should be implemented first**, with the appropriate unit tests, etc.
        * That way it can be used as a baseline to ensure any improvements are working


### Testing

* There can be a test-set of `Jobs`, `Persons`, and `Preferences`, for which the solution is obvious; and it compares the returned solution against the obvious solution.


## Possible prior formulations

* It could be a [**Knapsack Problem**][1], or a [**Binpacking Problem**][2], aka a "[**Best Allocation Algorithm**][3]".
* It's also similar to the **filling-the-water problem** demonstrated by Martin Odersky in the "Functional Programming in Scala" class, as well as by Peter Norvig in the "Design of Programs" class.
    * Odersky used **breadth-first search**. I don't know what Norvig used.
    * That implies it's probably also similar to the `Bloxorz` program.
* It's probably also amenable to a [**Dynamically Programmed**][4] solution.

[1]: http://en.wikipedia.org/wiki/Knapsack_problem
[2]: http://en.wikipedia.org/wiki/Bin_packing_problem
[3]: http://stackoverflow.com/questions/2689296/best-allocation-algorithm
[4]: http://en.wikipedia.org/wiki/Dynamic_programming

## Cool futuristic features

* If it could figure out who would be easiest to switch with. Though doing that through this ignores socio-political considerations.

* When the schedule is done, it could print it such that the **squares are colored like a heatmap**. Like the ones in *higher demand* (less total points) are *redder* or something.
    * That way if you didn't get that thing you really wanted, you can see if 
        * a lot of other people really wanted it, and find some solace in it, or
        * not a lot of other people really wanted it, and maybe you can trade with whomever got it.

* It would be fun to see the histogram of cost scores over all the possible allocations.
    * This is only possible if every possible allocation is calculated...

* If I ever switch to a snazzy algorithm, it would be cool to see the line graph of scores traversed to reach the final (likely *non-optimal*) one
