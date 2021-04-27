<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="pageTitle" scope="request" value="Admin "/>
<%@include file="../layout/admin/header.jsp" %>


<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark">Dashboard</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
        <figure class="highcharts-figure">
            <div id="container"></div>
            <p class="highcharts-description">
                Chart showing browser market shares. Clicking on individual columns
                brings up more detailed data. This chart makes use of the drilldown
                feature in Highcharts to easily switch between datasets.
            </p>
        </figure>
    </section>
    <!-- /.content -->
</div>

<jsp:include page="../layout/admin/footer.jsp"/>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script>
    // Create the chart
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Browser market shares. January, 2018'
        },
        subtitle: {
            text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
        },
        accessibility: {
            announceNewData: {
                enabled: true
            }
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: 'Total percent market share'
            }

        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}%'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
        },

        series: [
            {
                name: "Browsers",
                colorByPoint: true,
                data: [
                    {
                        name: "January",
                        y: 62.74,
                    },
                    {
                        name: "February",
                        y: 10.57,
                    },
                    {
                        name: "March",
                        y: 7.23,
                    },
                    {
                        name: "April",
                        y: 5.58,
                    },
                    {
                        name: "May",
                        y: 4.02,
                    },
                    {
                        name: "June",
                        y: 1.92,
                    },
                    {
                        name: "July",
                        y: 7.62,
                    },
                    {
                        name: "August",
                        y: 7.62,
                    },
                    {
                        name: "September",
                        y: 7.62,
                    },
                    {
                        name: "October",
                        y: 7.62,
                    },
                    {
                        name: "November",
                        y: 7.62,
                    },
                    {
                        name: "December",
                        y: 7.62,
                    }
                ]
            }
        ]
    });
</script>
