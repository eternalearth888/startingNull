class throttle {
	public:
		//MODIFCIATION MEMBER FUNCTIONS
		// A function to set a throttle to its shutoff position
		void shut_off();

		//A function to shift a throttle's position by a given amount
		void shift(int amount);

		//CONSTANT MEMBER FUNCTIONS
		//A function that returns the fuel flow, expressed as a proportion of the maximum flow
		double flow() const;
		//A function to tell us whether the throttle is currently on
		bool is_on() const;

	private:
		int position;
}	