package com.epam.demo.signature.starter.autoconfigure;

import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Duration;

@Validated
@ConfigurationProperties("demo.signature")
public class SignatureProperties {

    /**
     * Username that is used in email signature.
     */
    @NotBlank
    @Size(min = 5, max = 100)
    private String username = "NONAME";

    @Valid
    @NestedConfigurationProperty
    private Extra extra = new Extra();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public static class Extra {

        /**
         * Retention period of email.
         */
        @DurationMin(minutes = 5)
        @DurationMax(hours = 1)
        private Duration retentionPeriod = Duration.ofMinutes(5);

        public Duration getRetentionPeriod() {
            return retentionPeriod;
        }

        public void setRetentionPeriod(Duration retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }
    }
}
