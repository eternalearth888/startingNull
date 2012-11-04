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

#Testing a condition: if..then
#	making sure to not accept a negative subtotal
	if (subtotal < 0.0) then
		subtotal=0.0
	end

#can be written like this: if (subtotal<0.0) then subtotal = 0.0 end
#but it adds nothing to the clarity of the form

	tax=subtotal*taxrate
	puts "Tax on$#{subtotal} is $#{tax}, so grandtotal is $#{subtotal+tax}"

#Comments
	# are for single lines
=begin
This is a
multiline
comment
=end

