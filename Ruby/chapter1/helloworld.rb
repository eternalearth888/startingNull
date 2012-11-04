#!/usr/bin/ruby
#Hello World program
	puts 'hello world'

#Getting and Putting input
	print( 'Enter your name:' )
	name = gets()
	puts( "Hello #{name}")

#Strings and Embedded Evaluation
	puts( "\n\t#{(1+2) * 3}\nGoodbye" )

#Numbers
	taxrate = 0.175
	print "Enter price: "
	s = gets
	subtotal = s.to_f
	tax=subtotal*taxrate
	puts "Tax on$#{subtotal} is $#{tax}, so grandtotal is $#{subtotal+tax}"

#Comments
	# are for single lines
=begin
This is a
multiline
comment
=end

