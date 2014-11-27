
Feature: an user can see the moments and comments of her friends in Wechat Moments

Scenario: an user can see a moment of her friend
Given Kongzi is the Wechat friend of Ben
And Kongzi sends a moment "When right principles of government prevail in the kingdom, he will show himself." in Wechat Moments
When Ben checks the Wechat Moments
Then Ben could see the moment "When right principles of government prevail in the kingdom, he will show himself." from Kongzi in Wechat Moments

Scenario: an user cannot see a moment of an user who is not her friend
Given Laozi is not the Wechat friend of Ben
And Laozi sends a moment "The Sage relies on actionless activity." in Wechat Moments
When Ben checks the Wechat Moments
Then Ben could not see the moment "The Sage relies on actionless activity." from Laozi in Wechat Moments
