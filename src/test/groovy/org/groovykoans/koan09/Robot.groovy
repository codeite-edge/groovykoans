/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan09

import org.codehaus.groovy.runtime.InvokerHelper

class Robot {
    // ------------ START EDITING HERE ----------------------

    int x = 0, y = 0

    def up() { y++ } 

    def down() { y-- }

    def left() { x-- }

    def right() { x++}

    Object invokeMethod(String name, Object args) {
    	if(name.startsWith('go')) {
		(name =~ /(Up|Down|Left|Right)/).each {
	        	def methodName = it[0].toLowerCase()
		        def metaMethod = InvokerHelper.getMetaClass(this).getMetaMethod(methodName, args)
		        metaMethod.invoke(this, args)
	         }
         }
    }
    // ------------ STOP EDITING HERE  ----------------------
}
