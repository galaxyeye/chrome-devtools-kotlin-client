package ai.platon.cdt.protocol.commands;

/*-
 * #%L
 * cdt-java-client
 * %%
 * Copyright (C) 2018 - 2021 Kenan Klisura
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import ai.platon.cdt.protocol.events.performance.Metrics;
import ai.platon.cdt.protocol.support.annotations.EventName;
import ai.platon.cdt.protocol.support.annotations.Experimental;
import ai.platon.cdt.protocol.support.annotations.Optional;
import ai.platon.cdt.protocol.support.annotations.ParamName;
import ai.platon.cdt.protocol.support.annotations.ReturnTypeParameter;
import ai.platon.cdt.protocol.support.annotations.Returns;
import ai.platon.cdt.protocol.support.types.EventHandler;
import ai.platon.cdt.protocol.support.types.EventListener;
import ai.platon.cdt.protocol.types.performance.EnableTimeDomain;
import ai.platon.cdt.protocol.types.performance.Metric;
import ai.platon.cdt.protocol.types.performance.SetTimeDomainTimeDomain;
import java.util.List;

public interface Performance {

  /** Disable collecting and reporting metrics. */
  void disable();

  /** Enable collecting and reporting metrics. */
  void enable();

  /**
   * Enable collecting and reporting metrics.
   *
   * @param timeDomain Time domain to use for collecting and reporting duration metrics.
   */
  void enable(@Optional @ParamName("timeDomain") EnableTimeDomain timeDomain);

  /**
   * Sets time domain to use for collecting and reporting duration metrics. Note that this must be
   * called before enabling metrics collection. Calling this method while metrics collection is
   * enabled returns an error.
   *
   * @param timeDomain Time domain
   */
  @Deprecated
  @Experimental
  void setTimeDomain(@ParamName("timeDomain") SetTimeDomainTimeDomain timeDomain);

  /** Retrieve current values of run-time metrics. */
  @Returns("metrics")
  @ReturnTypeParameter(Metric.class)
  List<Metric> getMetrics();

  /** Current values of the metrics. */
  @EventName("metrics")
  EventListener onMetrics(EventHandler<Metrics> eventListener);
}
