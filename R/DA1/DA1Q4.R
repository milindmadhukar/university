# Problem 4: According to the census of 1991,
# following are the population figure, in thousands, of 30 cities:
# 1670, 2100, 1400, 1250, 2100, 1670, 1800, 900, 1450,
# 1892, 3650, 1670, 1250, 2100, 700, 1800, 650, 1670,
# 570, 1800, 488, 1670, 2100, 1800, 700, 900, 2100, 1670, 1670, and 1700.
#
# a) Use R to find mean, mode, median and standard deviation of the above
# population with given raw data directly.
# b) Use R to convert given data into ordered frequency data and then find the
# mean, mode, median, and standard deviation for the converted frequency
# data.

pollution_figure <- c(
  1670, 2100, 1400, 1250, 2100, 1670, 1800, 900, 1450,
  1892, 3650, 1670, 1250, 2100, 700, 1800, 650, 1670,
  570, 1800, 488, 1670, 2100, 1800, 700, 900, 2100, 1670, 1670, 1700
)
pollution <- table(pollution_figure)

mean_pollution1 <- mean(pollution_figure)
print(paste("Mean pollution:", mean_pollution1))

mode_pollution_idx1 <- which(pollution == max(pollution))
mode_pollution1 <- names(mode_pollution_idx1)
print(paste("Mode pollution:", mode_pollution1))

median_pollution1 <- median(pollution_figure)
print(paste("Median pollution:", median_pollution1))

var_pollution1 <- var(pollution_figure)
sd_pollution1 <- sqrt(var_pollution1)

print(paste("Standard deviation pollution:", sd_pollution1))

pollution_data <- as.numeric(names(pollution))
pollution_freq <- as.numeric(pollution)

mean_pollution2 <- sum(pollution_data * pollution_freq) / sum(pollution_freq)
print(paste("Mean pollution:", mean_pollution2))

mode_pollution_idx2 <- which(pollution_freq == max(pollution_freq))
mode_pollution2 <- pollution_data[mode_pollution_idx2]
print(paste("Mode pollution:", mode_pollution2))

median_pollution2 <- median(rep(pollution_data, pollution_freq))
print(paste("Median pollution:", median_pollution2))

var_pollution2 <- sum(
  pollution_freq * (pollution_data - mean_pollution2)^2
) / sum(pollution_freq)

sd_pollution2 <- sqrt(var_pollution2)
print(paste("Standard deviation pollution:", sd_pollution2))
