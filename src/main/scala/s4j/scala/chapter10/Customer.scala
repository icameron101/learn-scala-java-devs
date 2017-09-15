package s4j.scala.chapter10

package example1 {

  class Customer(forename: String, initial: String, surname: String) {

    // primary constructor
    val fullname = String.format("%s %s. %s", forename, initial, surname)

    // auxiliary constructor
    def this(forename: String, surname: String) {
      this(forename, "", surname)
    }
  }

}

package example2 {
  // default values on constructor
  class Customer(forename: String, initial: String = "", surname: String) {

    // primary constructor
    val fullname = if (initial != null && !initial.isEmpty)
      forename + " " + initial + ". " + surname
    else
      forename + " " + surname
  }

}

package example3 {

  class Customer(val name: String, val address: String) {
    private val id = Customer.nextId()
  }

  // companion object
  object Customer {
    private var lastId = 0

    private def nextId(): Integer = {
      lastId += 1
      lastId
    }
  }
}

package example4 {
  // creation method apply
  class Customer private (val name: String, val address: String) {
    val id = Customer.nextId()
  }

  object Customer {
    def apply(name: String, address: String) = new Customer(name, address)

    def nextId() = 1
  }

  object Example {
    Customer.apply("Bob Fossil", "1 London Road")
    Customer("Bob Fossil", "1 London Road")

    // doesn't compile. Do you know why?
    // new Customer("Bob Fossil", "1 London Road")

  }
}