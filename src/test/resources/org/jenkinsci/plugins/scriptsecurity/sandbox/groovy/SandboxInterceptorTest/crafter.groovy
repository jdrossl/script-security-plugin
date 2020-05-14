import org.codehaus.groovy.runtime.StackTraceUtils

// test support for gpah get method

class GPathSupport {
    def get(String expr) {
        "gpath ok"
    }
}

assert new GPathSupport().anything == "gpath ok"

// test support for DSL no arg methods

assert [1, 2].size == 2

assert [sort:'a'].sort == 'a'

// test support for special one arg methods

class WeirdCall {
    def test(obj) {
        obj
    }
}

def t = new WeirdCall()

assert t.test(1) == 1

assert t.test() == null

// conflict with gpah & get method

class Conflict {
    def getProp() {
        "ok"
    }

    def get(String arg) {
        "gpath"
    }
}

assert new Conflict().prop == "ok"

assert new Conflict().test == "gpath"

// test closure to lambda compatibility

["it", "works"].forEach({
    println it.toUpperCase()
})
