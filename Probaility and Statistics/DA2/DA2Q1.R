# Collect the data for 50 pair of observations say �𝑥𝑖,
# 𝑦𝑖�, 𝑖 = 1,2, … 50. Here, the pair
# of observations �𝑥𝑖,
# 𝑦𝑖� can be represent heights and weights of a 50 persons, or
# heights of father and sons, or price and sales of a product per 50 days,
# marks of 50 students in two different subjects
# and so on . Write the R code to obtain the
# coefficient of linear relationship between the above said
# pair of observations and comment on the result.

data <- read.delim("./father_son_heights.csv", header = TRUE, sep = ",")
fathers_height <- data$fathers_height
sons_height <- data$sons_height

# Correlation coefficient
print(cor(fathers_height, sons_height))

linear_model <- lm(fathers_height ~ sons_height)

summary(linear_model)
