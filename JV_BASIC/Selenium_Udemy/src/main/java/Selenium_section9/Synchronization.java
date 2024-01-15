package Selenium_section9;

public class Synchronization {
    public static void main(String[] args) {
        /*
        Scenario: Entering a form or searching for movies flights
        Step 1: Input searching data
        Step 2: Click Search
        Step 3: Wait for searching ~ a few sec - User can either be brought to another loading screening or loading icon
        Step 4: Results

        1. Implicit Wait:
        - define wait time globally
        - wait for n number of seconds before you throw exception
        - Do step 1 (wait for step to complete within n sec), then do step 2 (wait for step to complete within n sec)
        - if it takes less than n sec for the step to be executed, then it will stop waiting and proceed to the next step
        * performance issues may not get caught

        2. Explicit Wait:
        - specifically target a location and wait for a period of duration.
        - only apply to targeted elements. Avoid performance issue
        - WebdriverWait - 10 sec
        * more codes

        3. Thread.sleep:
        - A Java function, not a Selenium's
        - wait for a period of time before executing the next line of code
        - in real time scenario, this method is not recommended

        4. Fluent Wait:
        - a type of explicit wait
        - find web element repeatedly at regular intervals of time until the timeout or the element gets found . like a cron job - search for 5 sec, wait for 5 sec, then again.
        - need to build customised waiting method
        - convenient to use in a scenario in which after you check out at an ecommerce website. The UI will show "Your card is accepted" at the 3rd sec, and there will be another noti popup at the 7sec. Put this wait to look for the 2nd noti to pass the test
        - WebdriverWait - 10 secs, polling 4 sec - find an element every 4 second during the time frame of 10 sec. If none of the items were found after 10 sec, the test will timeout and fail
        - Both WedriveWait and FluentWait are 2 classes implening Wait Interface
         */
    }
}
