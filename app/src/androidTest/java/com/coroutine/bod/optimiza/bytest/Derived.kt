package com.coroutine.bod.optimiza.bytest

class Derived(b:IBase) :IBase by b{
    override fun test() {
        super.test()
    }

}