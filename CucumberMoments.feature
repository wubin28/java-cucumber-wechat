
Feature: an user can see the moments and comments of her friends in Wechat Moments

Scenario: an user can see a moment of her friend
Given Kongzi is the Wechat friend of Ben
And Kongzi sends a moment "Yanhui did not repeat a fault." in Wechat Moments
When Ben checks the Wechat Moments
Then Ben could see the moment "Yanhui did not repeat a fault." from Kongzi in Wechat Moments



